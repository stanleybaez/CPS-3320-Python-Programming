#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
CREATOR: KATLIN AND ALIL
COLLEGE LOAN APPLICATION

"""
print(" COLLEGE LOAN APPLICATION.")
## NEEDS MORE!!!

name = input(" ENTER NAME: ") ## TEMP.
## AcctNum = input (" ENTER ACCOUNT NUMBER: ") ## could take the information from account. 
history = int(input(" How many years have you had credit:"))
credit = int(input(" ENTER YOUR CREDIT SCORE:  "))
amount = int(input(" ENTER LOAN RESQUEST AMOUNT :  "))
school = input(" ENTER UNIVERSITY NAME: ") 
STUname = input(" ENTER ATTENDING STUDENT NAME: ")


if history >= 1 :
    print(name, " YOU WILL DECLINED FOR THE LOAN AMOUNT OF " , amount ,". Need to HAVE MORE THAN  12 months of credit HISTORY.")

elif credit < 699 and amount >= 1500 :
    print(name, " YOU WILL NOT BE ACCECPTED FOR THE LOAN AMOUNT OF " , amount ,".YOUR CREDIT ISNT HIGH ENOUGH.")
## if credit is less than 699 and the amount is greatter than 1500, gets declined.


elif credit >= 700  and amount <= 12000:
    print(name, " YOU WILL BE ACCECPTED FOR THE LOAN AMOUNT OF " , amount , ". YOUR INTEREST RATE is 11%. ")
    print(" THE LOAN AMOUNT OF ", amount ," WILL BE SENT  TO ", school, " FOR THE STUDENT : ", STUname)
##

elif credit<= 720 and amount == 20000 :
    print(name, " YOU WILL NOT BE ACCECPTED FOR THE LOAN AMOUNT OF " , amount ,".YOUR CREDIT ISNT HIGH ENOUGH.")
##


elif credit < 760 and amount <= 20000 :
    
      print(name, " YOU WILL BE ACCECPTED FOR THE LOAN AMOUNT OF " , amount, ". YOUR INTEREST RATE is 7%. ")
      print(" THE LOAN AMOUNT OF ", amount ," WILL BE SENT  TO ", school, " FOR THE STUDENT : ", STUname)
##

else:
    print(" INVAILD INPUT")