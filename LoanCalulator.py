#!/usr/bin/env python3
# -*- coding: utf-8 -*-

def loanCalc(loan, interestRate, month ):
 #monthly interest rate  would be :
    mInterestR = interestRate /12
    years =month/12
    print("Years: " , years)

    #monthly payments would be:
    mPayment = loan * mInterestR
 #Formula to calculate monthly payments
    Payment=(interestRate/12) * (1/(1-(1+interestRate/12)**(-month)))*loan

 #The balance after a payment would be :
    balanceAfterPayment = loan 
    
 #printing the total owed:
    print("Your  Monthly Payments are : $%.2f " % Payment)
    print ("Remaining balance is $%.2f : " % balanceAfterPayment) 
    
 # this loop is for the changing balance after every month and will print the month, payment and remaining balance until the balance is fully paid:
    for i in range ( 1 , month+1 ):
        balanceAfterPayment = (balanceAfterPayment - Payment) * ( 1 + mInterestR)
        print("\n Month: " , i)
        print("Payment: $%.2f" % Payment)
        print("Remaining Balance: $%.2f" % balanceAfterPayment)

def main():
     loan= int(input("Loan Amount:   "))
     interestRate = float(input("Interest rate: ( Give  in demcimal form ): "))
     month = int(input("Months of Payments (12,24,36 ,etc ): "  )) 
     loanCalc(loan, interestRate, month)
main()