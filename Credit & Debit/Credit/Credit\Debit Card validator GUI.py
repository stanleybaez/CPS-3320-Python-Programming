import tkinter as tk

class SampleApp(tk.Tk):
    
#GUI setup
    def __init__(self):
        tk.Tk.__init__(self)
        
        #GUI title
        self.title('Credit/Debit Card')
        
        #GUI background color
        self.configure(bg='orange')
        
        #GUI size when first launched
        self.geometry("300x200")
        
        #the welcome text
        self.label = tk.Label(self, text="Please enter the 16 digit credit card number : ", bg='orange')
        
        #input box
        self.UserInput = tk.Entry(self, show = '*', bg='orange')
        
        #the confirm button
        self.confirm = tk.Button(self, text="Confirm", command=self.validator, bg='orange')
        
        self.label.pack()
        self.confirm.pack()
        self.UserInput.pack()

#A function with two conditions to check the user's input to see if they entered a valid card
    def validator(self):
        
        #first condition
        if not (len(self.UserInput.get()) == 16) or not type(int(self.UserInput.get()) == int) :
            self.retry = tk.Button(self, text="Try again?", command=self.Retry, bg='orange')
            self.retry.pack()
            self.wrong = tk.Label(self, text="That is not a proper credit card number. \nMake sure you are entering digits not characters and all the 16 digits.", bg='orange')
            self.wrong.pack()
            self.confirm.destroy()
        else:
            validatelist=[]
        
        
            for i in self.UserInput.get():
                validatelist.append(int(i))


            for i in range(0,len(self.UserInput.get()),2):


                validatelist[i] = validatelist[i]*2

                if validatelist[i] >= 10:

                    validatelist[i] = validatelist[i]//10 + validatelist[i]%10

            #second condition
            if sum(validatelist)%10 == 0:
                self.valid = tk.Label(self, text="This a valid credit card", bg='orange')
                self.valid.pack()
                
                
            #Extra conditions that checks the card type 
                if self.UserInput.get()[0] == "1":
                    self.cardType = tk.Label(self, text="Airlines", bg='orange')
                if self.UserInput.get()[0] == "2":
                    self.cardType = tk.Label(self, text="Airlines & Financial", bg='orange')
                if self.UserInput.get()[0] == "3":
                    print("American Express")
                    self.cardType = tk.Label(self, text="American Express", bg='orange')
                if self.UserInput.get()[0] == "4":
                    print("Visa")
                    self.cardType = tk.Label(self, text="Visa", bg='orange')
                if self.UserInput.get()[0] == "5":
                    print("Master Card")
                    self.cardType = tk.Label(self, text="Master Card", bg='orange')
                if self.UserInput.get()[0] == "6":
                    print("Discover")
                    self.cardType = tk.Label(self, text="Discover", bg='orange')
                if self.UserInput.get()[0] == "7":
                    print("Petroleum")
                    self.cardType = tk.Label(self, text="Petroleum", bg='orange')
                if self.UserInput.get()[0] == "8":
                    print("Health Care & Telecommunications")
                    self.cardType = tk.Label(self, text="Health Care & Telecommunications", bg='orange')
                if self.UserInput.get()[0] == "9":
                    print("Open for Assignment")
                    self.cardType = tk.Label(self, text="Open for Assignment", bg='orange')
                self.cardType.pack()
                #print('This a valid credit card') 

                
                
                
                
            else:
                self.retry2 = tk.Button(self, text="Try again?", command=self.Retry2, bg='orange')
                self.retry2.pack()
                self.invalid = tk.Label(self, text="This is not valid credit card", bg='orange')
                self.invalid.pack()
                self.confirm.destroy()
        
        #the try again button if user's input failed to pass the second condition
    def Retry2(self):
        self.invalid.destroy()
        self.retry2.destroy()
        self.confirm = tk.Button(self, text="Confirm", command=self.validator, bg='orange')
        self.confirm.pack()
        
        #the try again button if user's input failed to pass the first condition
    def Retry(self):
        self.wrong.destroy()
        self.retry.destroy()
        self.confirm = tk.Button(self, text="Confirm", command=self.validator, bg='orange')
        self.confirm.pack()
        #print(self.UserInput.get())        
app = SampleApp()
app.mainloop()

#valid card 16 digits example
#4276983748842032
#6011356599462496
#3448482730607508
