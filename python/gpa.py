from cmath import sqrt
import csv
from ctypes import sizeof
from re import I
from statistics import stdev

def get_LETTER(grade):
    global letter_index
    #global charact
    letter = ["F-","F","F+","E-","E","E+","D-","D","D+","C-","C","C+","B-","B","B+","A-","A","A+"]
    
    gpavalue = [0.8,1.0,1.2,1.4,1.6,1.8,2,2.2,2.4,2.6,2.8,3,3.2,3.4,3.6,3.8,4,4.2]
    i = 10
    #grade = 0
    
    for i in range(10,100, 5):
        #print(i)
        if(grade >= i):
            if ((i + 5) > grade):
                 letter_index = ((i / 5) - 2)
                 #return letter_index
                 return letter[int(letter_index)]
        

def calculate_GPA(grade):
    gpavalue = [0.8, 1.0, 1.2, 1.4, 1.6, 1.8, 2, 2.2, 2.4, 2.6, 2.8, 3, 3.2, 3.4, 3.6, 3.8, 4, 4.2]
    i = 10
    for i in range(10,100, 5):
        #print(i)
        if(grade >= i):
            if ((i + 5) > grade):
                 gpa_index = ((i / 5) - 2)
                 #return letter_index
                 #return letter[int(letter_index)]
    gpa_value = gpavalue[int(gpa_index)]
    return gpa_value
    
    
def average(data):
    avg = sum(data) / len(data)
    return avg

# The functions "mean", "variance" and "stddev" will calculate the standard deviation
# Source: stackoverflow (https://stackoverflow.com/questions/36830737/writing-a-standard-deviation-function)
def mean(data):
    return float(sum(data) / len(data))

def variance(data):
    mu = mean(data)
    return mean([(x - mu) ** 2 for x in data])

def stddev(data):
    #print (sqrt(variance(data)))
    return sqrt(variance(data))

def newModules():
    global new_mod_name
    new_mod_name = []
    global new_mod_grade
    new_mod_grade = []
    
    print('Enter Modules name and grades\n')
    for i in range(6):
        modName = str(input('Module %d:\n' %(i + 1)))
        modGrade = int(input('\nGrade for Module %s\n' % str(modName)))
        while ((modGrade > 99) or (modGrade < 1)):
            print(">> Grades must be between 1 and 99, please try again! <<\n")
            modGrade = int(input('\nGrade for Module %s\n' % str(modName)))
        print('')
        
        
        new_mod_name.append(modName)
        new_mod_grade.append(modGrade)
    
    print('GPA:  %.2f' % (calculate_GPA(average(new_mod_grade) )))
    for i in range(len(new_mod_grade)):
        print('Letter: %s, Module: %s' % (get_LETTER(new_mod_grade[i]), new_mod_name[i]))
    
def reprint():
    try:
        print('\nGPA:  %.2f' % (calculate_GPA(average(new_mod_grade) )))
        for i in range(len(new_mod_grade)):
            print('Letter: %s, Module: %s' % (get_LETTER(new_mod_grade[i]), new_mod_name[i]))
    except:
        
        print('\nNo grades have been entered yet')

def menu():
    print('1) See all notes')
    print('2) Enter Grades')
    print('3) Reprint entered notes')
    print('0) Quit')

def printValues():
    global letter_index
    with open('../CTASample.csv') as csvfile:
        next(csvfile)
        reader = csv.reader(csvfile)

        count = 0
        
        # Defining arrays
        students = []
        col_mod1 = []
        col_mod2 = []
        col_mod3 = []
        col_mod4 = []
        col_mod5 = []
        col_mod6 = []
        grades = [None] * 6
        module_name = ['Intro to Programming', 'Databases', 'Computer Architecture', 'Ethics in Computer Science', 'Advanced Programming', 'Puzzles and Problem Solving']
        
        
        for row in reader:
            count += 1
            # creating array from columns
            students.append(row[0])
            col_mod1.append(row[1])
            col_mod2.append(row[2])
            col_mod3.append(row[3])
            col_mod4.append(row[4])
            col_mod5.append(row[5])
            col_mod6.append(row[6])

    i = 0
    j=0
    for i in range(len(students)):
        
        # converts column index into row index - this process assigns row grades to each student
        grades[0] = int(col_mod1[i])
        grades[1] = int(col_mod2[i])
        grades[2] = int(col_mod3[i])
        grades[3] = int(col_mod4[i])
        grades[4] = int(col_mod5[i])
        grades[5] = int(col_mod6[i])
        
        grades_average = average(grades)
        max_index = grades.index(max(grades))
        
            
        print('%s - GPA:  %.2f' % ((students[i]), calculate_GPA(grades_average)))
        for j in range(len(grades)):
            print('Letter: %s, Module: %s' % (get_LETTER(int(grades[j])), module_name[j]))
            
        print('Highest scoring: %d, Module: %s' % (max(grades), module_name[grades.index(max(grades))]))
        print('Lowest scoring: %d, Module: %s' % (min(grades), module_name[grades.index(min(grades))]))
        print('Standard Deviation: %.3f' % (stddev(grades)).real) # we only want the "real" part of that number
        print('Median Value: %.2f' % (average(grades)))
        print('')
    #print(get_LETTER(50))
            
def main():
    menu()
    option = int(input('Enter Choice: '))
    
    
    while option != 0:
        if option == 1:
            printValues() 
        elif option == 2:
            newModules()
        elif option == 3:
            reprint()
                
        print()
        menu()
        option = int(input('Enter Choice: '))
    print('Thanks for using this program. ')
    
if __name__== "__main__":
    main()     