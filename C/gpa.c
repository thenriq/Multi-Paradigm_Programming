/*
sources:
https://stackoverflow.com/questions/35831715/create-array-of-strings-inside-of-struct

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <stdbool.h>
#define max_modules 6

typedef struct Courses {
    char module_name[50];
    char student_name[50];
    char m1[50];
    char m2[50];
    char m3[50];
    char m4[50];
    char m5[50];
    char m6[50];

}courses;

typedef struct Modules_input {
    char new_module_name[50];
    int new_m1;

}modules_input;


//Global variables
float temp_Marks[max_modules];
int avg;
int row_count = 0;

void printValues(courses values[]);
void newModules(modules_input nM[]);
void reprint(modules_input nM[]);
int main() {
    FILE * fp = fopen("../CTASample.csv", "r");
    if (!fp) {
        printf("Error occured");
        return 0;
    }

    char buff[1024]; //stores the first 1024 lines into buff

    int field_count = 0;

    courses values[999]; //array to structs to store values
    modules_input nM[999];
    

    
    // assigning course names to struct "Courses"
    strcpy(values[1].module_name, "Intro to Programming");
    strcpy(values[2].module_name, "Databases");
    strcpy(values[3].module_name, "Computer Architecture");
    strcpy(values[4].module_name, "Ethics in Computer Science");
    strcpy(values[5].module_name, "Advanced Programming");
    strcpy(values[6].module_name, "Puzzles and Problem Solving");
    
    int i = 0;
    while (fgets(buff, 1024, fp)) {
        field_count = 0;
        row_count++;
        if (row_count == 1)
            continue;
        char * field = strtok(buff, ","); // separate buff with commas
        while (field) {
            if (field_count == 0)
                strcpy(values[i].student_name, field);

            if (field_count == 1) {
                strcpy(values[i].m1, field);
            }

            if (field_count == 2) {
                strcpy(values[i].m2, field);
            }

            if (field_count == 3)
                strcpy(values[i].m3, field);

            if (field_count == 4)
                strcpy(values[i].m4, field);

            if (field_count == 5)
                strcpy(values[i].m5, field);

            if (field_count == 6)
                strcpy(values[i].m6, field);

            field = strtok(NULL, ",");
            field_count++; // update field value
        }

        i++;
    }

    fclose(fp);

    int choice = 0;

    // menu to the user
    while (true) {
        // present the menu, accept the user's choice
        printf("\n1) See all notes\n");
        printf("2) Enter Grades\n");
        printf("3) Reprint entered notes\n");
        printf("0) Quit\n");
        printf("Enter Choice: ");
        scanf("%d", & choice);
        

        // decide what action to carry out based on the user's choice
        switch (choice) {
            // print values
        case 1:
            printValues(values);

            break;

            // Enter new grades
        case 2:
            newModules(nM);

            break;
            
            // Reprint grades entered by user
        case 3:
            reprint(nM);

            break;

            // quit 
        case 0:
            printf("Thanks for using this program. \n");
            exit(0);
            
        }
    }
    

    return 0;
    
}

// Function to calculate average of an array
float average(float data[]) {
    int i;
    float sum = 0.0;
    for (i = 0; i < max_modules; i++) {
        sum += data[i];
    }

    return (sum / max_modules);

}

//Calculating GPA values based on grades from 0 to 100%
float calcule_GPA(float grade) {
    int grades, gpa_index;
    float gpa_value;
    double gpavalue[18] = { // array size 18 matches with number of elements of array letter (from A+ down to F-)
        0.8,
        1.0,
        1.2,
        1.4,
        1.6,
        1.8,
        2,
        2.2,
        2.4,
        2.6,
        2.8,
        3,
        3.2,
        3.4,
        3.6,
        3.8,
        4,
        4.2
    };

    for (int i = 10; i < 100; i += 5) { // 100 is the maximum grade allowed

        //GPA will be calculated on chunks of 5% increment
        if (grade >= i) {
            if ((i + 5) > grade) {
                gpa_index = ((i / 5) - 2);
            }
        }
    }

    gpa_value = gpavalue[gpa_index]; // assigning GPA value based on its index in array "gpavalue"
    return gpa_value;
}

//Calculating LETTERS values based on grades from 0 to 100%
const char * get_LETTER(double grade) {
    int grades, letter_index;
    float gpa_value;
    static char * letter[] = {
        "F-",
        "F",
        "F+",
        "E-",
        "E",
        "E+",
        "D-",
        "D",
        "D+",
        "C-",
        "C",
        "C+",
        "B-",
        "B",
        "B+",
        "A-",
        "A",
        "A+"
    };
    
    for (int i = 10; i < 100; i += 5) {
        if (grade >= i) {
            if ((i + 5) > grade) {
                letter_index = ((i / 5) - 2); // assigning GPA value based on its index in array
            }
        }
    }

    return letter[letter_index];
}

//Live mode - user input
void newModules(modules_input nM[]) {
    int result;

    printf("\nEnter Modules name and grades\n ");
    for (int i = 0; i < max_modules; i++) {
        printf("\nModule %d:\n", i + 1);
        scanf("%s", nM[i].new_module_name); // feeding new structure with input from user
        printf("\nGrade for Module %s\n", nM[i].new_module_name);
        scanf("%d", & nM[i].new_m1); // feeding new structure with input from user
        while ((nM[i].new_m1 > 99) || (nM[i].new_m1 < 1)){
            printf(">> Grades must be between 1 and 99, please try again! <<\n");
            printf("\nGrade for Module %s\n", nM[i].new_module_name);
            scanf("%d", & nM[i].new_m1);
        }
        temp_Marks[i] = nM[i].new_m1; // feeding temp array with content from new struct 
    }                                 //this will be used to calculate grades average, and then, to calculate GPA value 

    avg = average(temp_Marks);
    printf("\nGPA: %.2f\n", (calcule_GPA(avg))); // calling function "calculate_GPA"
    for (int j = 0; j < max_modules; j++) {
        temp_Marks[j] = nM[j].new_m1; // feeding array "temp_Marks with content from new struct
                                      // this will be used on "reprint" function  
        printf("Letter: %s, Module: %s\n", get_LETTER(nM[j].new_m1), nM[j].new_module_name);
    }
    printf("\n");
}

// Function to reprint previously entered new modules and marks
void reprint(modules_input nM[]) {
    //float x =  (calcule_GPA(avg));
    if ((calcule_GPA(avg)) == 0){ // No GPA calculated means that new grades were not entered by user
        printf("\nNo grades have been entered yet\n\n");
        
    } 
    else{
        printf("\nGPA: %.2f\n", (calcule_GPA(avg)));
        for (int j = 0; j < max_modules; j++) {
            temp_Marks[j] = nM[j].new_m1;

            printf("Letter: %s, Module: %s\n", get_LETTER(nM[j].new_m1), nM[j].new_module_name); //outputing marks and module names
        }
    }
}

// Function to calculate Standard Deviation
// Source: https://www.programiz.com/c-programming/examples/standard-deviation
float StandardDeviation(float data[]) {
    float sum = 0.0, mean, SD = 0.0;
    int i;
    for (i = 0; i < max_modules; ++i) {
        sum += data[i];
    }

    mean = sum / max_modules;
    for (i = 0; i < max_modules; ++i) {
        SD += pow(data[i] - mean, 2);
    }

    return sqrt(SD / max_modules);
}

void printValues(courses values[]) {
    int mod1, mod2, mod3, mod4, mod5, mod6, max, min, xyz, xzy;
    float myNumbers[6], sum, grades_average;

    for (int i = 0; i <= (row_count - 2); i++) {
        // Converting values from char into int
        mod1 = atof(values[i].m1);
        mod2 = atof(values[i].m2);
        mod3 = atof(values[i].m3);
        mod4 = atof(values[i].m4);
        mod5 = atof(values[i].m5);
        mod6 = atof(values[i].m6);

        // Assigning converted values to a new array
        myNumbers[0] = mod1;
        myNumbers[1] = mod2;
        myNumbers[2] = mod3;
        myNumbers[3] = mod4;
        myNumbers[4] = mod5;
        myNumbers[5] = mod6;

        // Calculating average value from grades - this will be used to calculate GPA
        grades_average = average(myNumbers);

        // Printint all students names along with their GPA, letter marks and module names
        printf("\n%s - GPA: %.2f\n", values[i].student_name, calcule_GPA(grades_average));
        for (int j = 0; j < max_modules; j++) {
            printf("Letter: %s, Module: %s\n", get_LETTER(myNumbers[j]), values[j + 1].module_name);

        }

        // Calculating maximum grade
        xyz = 0;
        for (int i = 0; i < max_modules; ++i) {
            if (myNumbers[i] > max) {
                max = myNumbers[i];
                xyz = i;
            }
        }

        // Calculating minimum grade
        min = myNumbers[0];
        xzy = 0;
        for (int i = 0; i < max_modules; i++) {
            //Compare elements of array with min    
            if (myNumbers[i] < min) {
                min = myNumbers[i];
                xzy = i;
            }
        }

        printf("Highest scoring: %d, Module: %s\n", max, values[(xyz + 1)].module_name);
        printf("Lowest scoring: %d, Module: %s\n", min, values[(xzy + 1)].module_name);
        printf("Standard Deviation: %.3f\n", StandardDeviation(myNumbers));
        printf("Median Value: %.2f", grades_average);
        printf("\n");

        max = 0;
        min = 0;

    }
}