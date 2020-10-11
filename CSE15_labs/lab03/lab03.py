from logic import TruthTable

myTable = TruthTable([input("Enter your logic expression: ")])
userTable = myTable.table
tautologyList = []
contradictionList = []
userList = []

myTable.display()
print(userTable)

for x in userTable:
    userList.append(x[1][0])
    tautologyList.append(1)
    contradictionList.append(0)

print()
if userList == tautologyList:
    print("The expression is a tautology.")
elif userList == contradictionList:
    print("The expression is a contradiction.")
else:
    print("The expression is a contingency.")
