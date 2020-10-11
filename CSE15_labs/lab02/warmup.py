from logic import TruthTable

andTable = TruthTable(['p', 'q'], ['p and q'])
orTable = TruthTable(['p', 'q'], ['p or q'])
xorTable = TruthTable(['p', 'q'], ['(p or q) and -(p and q)'])
negTable = TruthTable(['p'], ['-p'])
implyTable = TruthTable(['p', 'q'], ['p -> q'])
iffTable = TruthTable(['p', 'q'], ['p <-> q'])
table1 = TruthTable(['a', 'b'], ['a and -b'])
table2 = TruthTable(['a', 'b', 'c'], ['(a and b) or -c'])


print("AND operation table: ")
andTable.display()
print("\nOR operation table: ")
orTable.display()
print("\nXOR operation table: ")
xorTable.display()
print("\nNOT operation table: ")
negTable.display()
print("\nImplication operation table: ")
implyTable.display()
print("\nIf and only if operation table: ")
iffTable.display()
print("\nTable one: ")
table1.display()
print("\nTable two: ")
table2.display()

