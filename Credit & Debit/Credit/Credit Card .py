#!/usr/bin/env python
# coding: utf-8

# In[5]:

#this code asks the user to enter a credit card number and checks if it's valid
def validator(n):
#checks if the user's input follows the credit card algorithm 
    validatelist=[]

    for i in n:
        validatelist.append(int(i))


    for i in range(0,len(n),2):


        validatelist[i] = validatelist[i]*2

        if validatelist[i] >= 10:

            validatelist[i] = validatelist[i]//10 + validatelist[i]%10


    if sum(validatelist)%10 == 0:
        print('This a valid credit card') 

    else:
        print('This is not valid credit card')

def cardnumber():
#asks the user to enter the credit card number and checks if the input is valid (a condition that checks if the input has 16 numbers and no characters and sympols in it)
    result=''
    while True:
        try:
            result = input('Please enter the 16 digit credit card number : ')

            if not (len(result) == 16) or not type(int(result) == int) :
                raise Exception

        except Exception:
            print('That is not a proper credit card number. \nMake sure you are entering digits not characters and all the 16 digits.')
            continue

        else:
            break


    return result

def goagain():
#asks the user if they want to check again
    return input('Do you want to check again? (Yes/No) : ').lower()[0] == 'y'

def main():
    
    while True:

        result = cardnumber()
        validator(result)

#ends the code
        if not goagain():
            break

if __name__ == '__main__':
    main()


# In[ ]:




