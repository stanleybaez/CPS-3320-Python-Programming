import tkinter as tk

class SampleApp(tk.Tk):
    def __init__(self):
        #self.wrong.destroy()
        tk.Tk.__init__(self)
        self.title('Credit/Debit Card')
        self.configure(bg='orange')
        self.geometry("300x200")
        self.label = tk.Label(self, text="Please enter the 16 digit credit card number : ", bg='orange')
        self.UserInput = tk.Entry(self, show = '*', bg='orange')
        self.confirm = tk.Button(self, text="Confirm", command=self.validator, bg='orange')
        self.label.pack()
        self.confirm.pack()
        self.UserInput.pack()
            
    def validator(self):
        #if self.cardType:
            #self.cardType.destroy()
        if not (len(self.UserInput.get()) == 16) or not type(int(self.UserInput.get()) == int) :
            self.retry = tk.Button(self, text="Try again?", command=self.Retry, bg='orange')
            self.retry.pack()
            self.wrong = tk.Label(self, text="That is not a proper credit card number. \nMake sure you are entering digits not characters and all the 16 digits.", bg='orange')
            self.wrong.pack()
            self.confirm.destroy()
        else:
            #self.wrong.destroy()
            validatelist=[]
        
        
            for i in self.UserInput.get():
                validatelist.append(int(i))


            for i in range(0,len(self.UserInput.get()),2):


                validatelist[i] = validatelist[i]*2

                if validatelist[i] >= 10:

                    validatelist[i] = validatelist[i]//10 + validatelist[i]%10

        
            if sum(validatelist)%10 == 0:
                self.valid = tk.Label(self, text="This a valid credit card", bg='orange')
                self.valid.pack()
                
                
                
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
            #print('This is not valid credit card')
        
    def Retry2(self):
        self.invalid.destroy()
        self.retry2.destroy()
        self.confirm = tk.Button(self, text="Confirm", command=self.validator, bg='orange')
        self.confirm.pack()
        
    def Retry(self):
        self.wrong.destroy()
        self.retry.destroy()
        self.confirm = tk.Button(self, text="Confirm", command=self.validator, bg='orange')
        self.confirm.pack()
        #print(self.UserInput.get())        
app = SampleApp()
app.mainloop()
#4276983748842032
#6011356599462496
#3448482730607508
