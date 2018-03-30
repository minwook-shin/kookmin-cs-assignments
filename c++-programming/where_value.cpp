#include<iostream>
#define STUDENT 5

using namespace std;

int main(){
    int grade[STUDENT];
    int sum =  0;
    int i,aver;

    for(i = 0; i< STUDENT; i++){
        cin >> grade[i];
    }

    cout<< "grade :" << grade << endl;

    cout<< "-1 :" << &grade[-1] << endl;

    for(i = 0; i< STUDENT; i++){
        cout << i << " : " << &grade[i]<<endl;
    }

    for(i = 0; i< STUDENT; i++){
        sum += grade[i];
    }

    aver = sum / STUDENT;

    

    cout<< "sum : " << &sum << endl;
    cout<< aver<<endl;

    return 0;
}