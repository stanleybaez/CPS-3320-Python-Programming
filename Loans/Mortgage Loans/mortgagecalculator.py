import numpy as np


def main():
    print ("Welcome to Kean's home loan ")

    #inputs
    price = float(input("Enter sale price of the house: "))
    down_payment =  float(input("Enter down payment as a percentage '5' = 5%: "))
    totaldown = down_payment * price
    loan_amount = price*(1-down_payment/100)
    years =  float(input("Enter mortgage type in years, '15' = 15 years: "))
    months = int(12*years)
    interest_rate =  float(input("Enter loan interest rate as a percentage, '3' = 3% "))
    R = 1 +(interest_rate)/(12*100)
    X = loan_amount*(R**months)*(1-R)/(1-R**months)
    monthly_interest = []
    monthly_balance  = []

    #loop for monthly payments
    for i in range(1,months+1):
        interest = loan_amount*(R-1)
        loan_amount = loan_amount - (X-interest)
        monthly_interest = np.append(monthly_interest,interest)
        monthly_balance = np.append(monthly_balance, loan_amount)

    #print results
    print("The home sales price is: = " + ('$')+ str(price))
    print("The down payment is: = "+ ('$') + str(totaldown/100))
    print("The loan amount is: = " + ('$')+ str(price*(1-down_payment/100)))
    print("The interest rate: = " + str(interest_rate)+(' %'))
    print("Duration of loan: = " + str(months)+(' months'))
    print("Monthly payment:: = " + ('$')+str(np.round(X,2)))
    print("Total interest paid: = " + ('$') + str(np.round(np.sum(monthly_interest),2)))
    
main()
