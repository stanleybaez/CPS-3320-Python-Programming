
# https://docs.google.com/spreadsheets/d/1NEJtGoXPrjqEwsBN_KZhev44HfeAW2tFo_ffFC0OWdM/edit#gid=0  <-- Account Sheet url

from __future__ import print_function
from ast import While

import os.path
import random
from datetime import date
from urllib import response

from google.auth.transport.requests import Request
from google.oauth2.credentials import Credentials
from google_auth_oauthlib.flow import InstalledAppFlow
from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
from numpy import append


# If modifying these scopes, delete the file token.json before running program.
# scopes give permissions like readOnly access vs allowing to write and make changes
# to google sheet
SCOPES = ['https://www.googleapis.com/auth/spreadsheets']

# Sets the ID and range of a sample spreadsheet.
# This is the spreadsheet ID for the Checking account tab VV
SAMPLE_SPREADSHEET_ID = '1NEJtGoXPrjqEwsBN_KZhev44HfeAW2tFo_ffFC0OWdM'
SAMPLE_RANGE_NAME = 'Checking Accounts!A1:O'


def main():
    """Shows basic usage of the Sheets API.
    Prints values from a sample spreadsheet.
    """
    creds = None

# The file token.json stores the user's access and refresh tokens, and is
# created automatically when the authorization flow completes for the first time.
# First checks if token.json file exists
    if os.path.exists('token.json'):
        creds = Credentials.from_authorized_user_file('token.json', SCOPES)

# If token.json file does not exist, asks the user to log in.
# after signing in, it will give a warning, click "advanced", then "go to banking", then "continue"
    if not creds or not creds.valid:
        if creds and creds.expired and creds.refresh_token:
            creds.refresh(Request())
        else:
            flow = InstalledAppFlow.from_client_secrets_file(
                'credentials.json', SCOPES)
            creds = flow.run_local_server(port=0)

# Saves the credentials in token.json file for the next run
        with open('token.json', 'w') as token:
            token.write(creds.to_json())


# After getting credentials from token.json file, tries to call sheets API
    try:
        service = build('sheets', 'v4', credentials=creds)

# Calls the Sheets API
        sheet = service.spreadsheets()
        result = sheet.values().get(spreadsheetId=SAMPLE_SPREADSHEET_ID,
                                    range=SAMPLE_RANGE_NAME).execute()
        values = result.get('values', [])


# says no data found if google sheet is empty
        if not values:
            print('No data found.')
            return


# Prompts user to give personal information and creates an account

        def createAccount():
            while True:

                accountType = input(
                    "\nwhat kind of account would you like to make? ")

                i = 0

                list = [[]]
                while i < len(values[0])-4:
                    i += 1
                    temp = input("\nWhat's your " + values[0][i - 1] + "?  ")
                    list[0].append(temp)

    # This adds an apostrophe before the zipcode so that
    # google sheets doesnt get rid of the leading 0
                list[0][4] = "'" + list[0][4]

    # gets all current account numbers and add them to an array
                currentAccountNumbers = []

                for x in values[1:]:
                    currentAccountNumbers.append(x[11])

    # Creates a random account number that hasnt been used hopefully
                r1 = random.randint(100000000, 999999999)
                while True:
                    flag = 0  # Tells the outter while loop if a repeat was found

                    for x in currentAccountNumbers:
                        if r1 == int(x):
                            print("repeat")
                            flag = 1

    # If a repeated Account number is found, generates a new one to use and checks again
                    if flag == 1:
                        r1 = random.randint(100000000, 999999999)
                        continue
                    break

                accountNumber = r1

    # Adds account number and type to array that will be
    # sent to Google sheets
                list[0].append(accountNumber)
                list[0].append(accountType)

    # Makes balance of newly created accounts $0
                list[0].append("$0")

    # Adds creation date for new account makes date format dd/mm/YY
                today = date.today()

                d1 = today.strftime("%B %d, %Y")
                list[0].append(str(d1))

    # Adds new row to google sheet with all gathered info
                resource = {
                    "majorDimension": "ROWS",
                    "values": list
                }

                service.spreadsheets().values().append(spreadsheetId='1NEJtGoXPrjqEwsBN_KZhev44HfeAW2tFo_ffFC0OWdM',
                                                       range='Checking Accounts!A2:N',
                                                       body=resource,
                                                       valueInputOption="USER_ENTERED").execute()
                print("\nAccount created successfully!")
                keepGoing = input(
                    "\nWould you like to create another account? ")

                if keepGoing == "no":
                    userMenu()


# Finds account by account number

        def findAccount(account):
            sheet = service.spreadsheets()
            result = sheet.values().get(spreadsheetId=SAMPLE_SPREADSHEET_ID,
                                        range=SAMPLE_RANGE_NAME).execute()
            values = result.get('values', [])

            for idx, val in enumerate(values[1:]):
                # idx, val in enumerate(ints):
                if val[11] == account:
                    row = [idx, val]
                    return row

            print("\nAccount not found. Try again")


# Deletes an account


        def deleteAccount():
            while True:
                response = input("\nPlease enter the account number: ")
                account = findAccount(response)

                spreadsheet_data = [
                    {
                        "deleteDimension": {
                            "range": {
                                "sheetId": "0",
                                "dimension": "ROWS",
                                # This row does not get deleted
                                "startIndex": (account[0] + 1),
                                # The index of the row that is actually deleted
                                "endIndex": (account[0] + 2)
                            }
                        }
                    }
                ]

                update_spreadsheet_data = {
                    "requests": spreadsheet_data}

                update_data = update_spreadsheet_data

                sheet.batchUpdate(
                    spreadsheetId="1NEJtGoXPrjqEwsBN_KZhev44HfeAW2tFo_ffFC0OWdM", body=update_data).execute()

                print("\nThe account has been deleted")
                go = input("\nWould you like to delete another account? ")
                if go == "no":
                    userMenu()

# Searches for account and returns balance
        def checkBalance():
            while True:
                response = input("\nPlease enter the account number: ")
                account = findAccount(response)
                print("\nThe balance of this account is: " + account[1][13])
                go = input("\nCheck the balance of another account? ")
                if go == "no":
                    userMenu()


# Searches for account and lowers the balance


        def withdraw():
            while True:
                response = input(
                    "\nPlease enter the account number to withdraw from: ")
                account = findAccount(response)
                print("\nYour current balance is: " +
                      account[1][13][1:])
                withdraw = float(input(
                    "\nPlease enter how much you would like to withdraw: "))

                batch_update_values_request_body = {
                    "valueInputOption": "RAW",
                    "data": [
                        {
                            'range': 'Checking Accounts!N' + str(account[0] + 2),
                            'values':  [["$" + str("{:.2f}".format(float((account[1][13][1:]).replace(",", "")) - withdraw))]]
                        },
                    ]
                }

                service.spreadsheets().values().batchUpdate(
                    spreadsheetId="1NEJtGoXPrjqEwsBN_KZhev44HfeAW2tFo_ffFC0OWdM",
                    body=batch_update_values_request_body
                ).execute()

                print("\nTansaction complete. Your new balance is: " +
                      "$" + str("{:.2f}".format(float((account[1][13][1:]).replace(",", "")) - withdraw)))
                go = input("\nWould you like to withdraw more? ")
                if go == "no":
                    userMenu()

# Searches for account and increases the balance
        def deposit():
            while True:
                response = input(
                    "\nPlease enter the account number to deposit to: ")

                account = findAccount(response)
                print("\nYour current balance is: " +
                      account[1][13])

                deposit = float(input(
                    "\nPlease enter how much you would like to deposit: "))

                batch_update_values_request_body = {
                    "valueInputOption": "RAW",
                    "data": [
                        {
                            'range': 'Checking Accounts!N' + str(account[0] + 2),
                            'values':  [["$" + str("{:.2f}".format(float((account[1][13][1:]).replace(",", "")) + deposit))]]
                        },
                    ]
                }

                service.spreadsheets().values().batchUpdate(
                    spreadsheetId="1NEJtGoXPrjqEwsBN_KZhev44HfeAW2tFo_ffFC0OWdM",
                    body=batch_update_values_request_body
                ).execute()

                print("\nTansaction complete. Your new balance is: " + "$" +
                      str("{:.2f}".format(float((account[1][13][1:]).replace(",", "")) + deposit)))
                go = input("\nWould you like to deposit more? ")
                if go == "no":
                    userMenu()


# Asks user what they would like to do

        def userMenu():
            while True:
                print(
                    "\nWelcome to your online banking system! What would you like to do? \n")
                print("Enter '1' to Create an account ")
                print("Enter '2' to Delete an account ")
                print("Enter '3' to Check your balance ")
                print("Enter '4' to withdraw money ")
                print("Enter '5' to deposit money ")
                print("Enter '6' to end program ")

                response = input("\nYour response:  ")

                if response == "1":
                    createAccount()
                elif response == "2":
                    deleteAccount()
                elif response == "3":
                    checkBalance()
                elif response == "4":
                    withdraw()
                elif response == "5":
                    deposit()
                elif response == "6":
                    print("\nProgram ended. Have a nice day! \n")
                    quit()
                else:
                    print("That was an invalid response. Try again. \n")
                    userMenu()


# Prints all accounts contained in the Checking accounts tab
        # for column in values:
        #     for x in column:
        #         print(x, end=" | ")
        #     print("\n")

        userMenu()


# if something goes wrong, this prints the error code thats returned
    except HttpError as err:
        print(err)


# starts the program
if __name__ == '__main__':
    main()
