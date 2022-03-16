#!/usr/bin/env python
# coding: utf-8

# In[38]:

#this code will create a GUI that asks the user to enter a credit card number, the number has to be 16 digits and it has to follow a certain algorithm (ex: 4642917704285981)
import tkinter as tk

class SampleApp(tk.Tk):
    def __init__(self):
        tk.Tk.__init__(self)
        self.label = tk.Label(self, text="Please enter the 16 digit credit card number : ")
        self.UserInput = tk.Entry(self)
        self.button = tk.Button(self, text="Confirm", command=self.validator)
        self.label.pack()
        self.button.pack()
        self.UserInput.pack()
        
    
    def validator(self):
#checks if the user's input follows the credit card algorithm 
        if not (len(self.UserInput.get()) == 16) or not type(int(self.UserInput.get()) == int) :
            self.wrong = tk.Label(self, text="That is not a proper credit card number. \nMake sure you are entering digits not characters and all the 16 digits.")
            self.wrong.pack()
        else:
            validatelist=[]
        
        
            for i in self.UserInput.get():
                validatelist.append(int(i))


            for i in range(0,len(self.UserInput.get()),2):


                validatelist[i] = validatelist[i]*2

                if validatelist[i] >= 10:

                    validatelist[i] = validatelist[i]//10 + validatelist[i]%10

        
            if sum(validatelist)%10 == 0:
                self.valid = tk.Label(self, text="This a valid credit card")
                self.valid.pack()
                #print('This a valid credit card') 

            else:
                self.invalid = tk.Label(self, text="This is not valid credit card")
                self.invalid.pack()          
            #print('This is not valid credit card')
        
        
    def on_button(self):
        print(self.UserInput.get())

app = SampleApp()
app.mainloop()
