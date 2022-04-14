#!/usr/bin/env python
# coding: utf-8

# In[45]:


class CheckingAccount:
    Checkingbalance = 0
    Checkingoldbalance = 0
    #amount = 0
   
    def __init__(self, Checkingbalance = 0):
        self.Checkingbalance = Checkingbalance
        
    def Checkingwithdraw(self, amount = 0):
        self.Checkingoldbalance = self.Checkingbalance
        if amount < self.Checkingbalance:
            self.Checkingbalance -= amount
            print("Amount checking withdrawn {}".format(amount))
        else:
            self.Checkingbalance -= amount + 20
            print("Amount checking withdraw ${} with penalty of $20".format(amount))
        
    def Checkingdeposit(self, amount = 0):
        self.Checkingoldbalance = self.Checkingbalance
        self.Checkingbalance += amount
        print("Amount checking deposit {}".format(amount))
        return amount
    
class SavingAccount:
    Savingbalance = 0
    Savingoldbalance = 0
    Savingbalance_YearsLater = 0
    Years = 0
    annual_Interest = 0.06
    #amount = 0
   
    def __init__(self, Savingbalance = 0, Years= 0):
        self.Savingbalance = Savingbalance
        self.Years = Years
        
    def SavingWithdraw(self, amount = 0, Years= 0):
        self.Savingoldbalance = self.Savingbalance
        if amount < self.Savingbalance:
            self.Savingbalance -= amount
            print("Amount saving withdrawn {}".format(amount))
        else:
            self.Savingbalance -= amount + 20
            print("Amount saving withdraw ${} with penalty of $20".format(amount))
        
    def SavingDeposit(self, amount = 0, Years= 0):
        self.Savingoldbalance = self.Savingbalance
        self.Savingbalance = self.Savingbalance + amount
        self.Savingbalance_YearsLater = self.Savingbalance * (1 + (self.Years * self.annual_Interest))
        print("Amount saving deposit {}".format(amount))
        return amount
    
      
an = CheckingAccount(80)

#an.Checkingwithdraw(70)
an.Checkingdeposit(70)

print("Your old checking balance was {}. Your new checking balance is now {}.".format(an.Checkingoldbalance, an.Checkingbalance))


      
an = SavingAccount(80, 2)
#an.withdraw(70)
an.SavingDeposit(70)

print("Your old saving balance was " + format(an.Savingoldbalance))
print("Your new saving balance after " + format(an.Years) + " years is " + format(an.Savingbalance_YearsLater))
#average saving account gives a +0.06% annually, marketing account depends on the user's account balance


# In[ ]:




