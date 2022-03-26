import tkinter as tk

class SampleApp(tk.Tk):
    def __init__(self):
        #self.wrong.destroy()
        tk.Tk.__init__(self)
        self.title('Credit Card GUI')
        self.configure(bg='orange')
        self.geometry("300x200")
        self.label = tk.Label(self, text="Please enter the 16 digit credit card number : ", bg='orange')
        self.UserInput = tk.Entry(self, show = '*', bg='orange')
        self.confirm = tk.Button(self, text="Confirm", command=self.validator, bg='orange')
        self.label.pack()
        self.confirm.pack()
        self.UserInput.pack()
            
    def validator(self):

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
