#include <stdio.h>
#include "stack.h"
#include <math.h>

#define MAX_SIZE 100

int main(){
  char ch = getchar();
  int num = 0;
  int temp = 0;
  int error = 0;
  double first = 0;
  double second = 0;
  int lastNum = 0;
  int count = 1;
  int few = 0;
  int full = 0;
  int fews = 0;
  double p;
  double result;

  while ((ch != '\n') && (error == 0)){
    if (isdigit(ch)){
      temp = ch - '0';
      num = num * 10;
      num = num + temp;
      lastNum = 1;
    }else{
      if (lastNum == 1){
	p = num;
	error = push(p);
	num = 0;
	temp = 0;
	lastNum = 0;
	
	if (error == -1){
	  full = 1;
	}
      }else{
	if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/')){
	  second = pop();
	  first = pop();

	  if ((isnan(first)) || (isnan(second))){
	    error = -1;
	    fews = 1;
	  }else if (ch == '+'){
	    p = first + second;
	  }else if (ch == '-'){
	    p = first - second;
	  }else if (ch == '*'){
	    p = first * second;
	  }else if (ch == '/'){
	    p = first / second;
	  }
	  if (error == 0){
	    error = push(p);
	    if (error == -1){
	      full = 1;
	    }
	  }
	}
      }
    }

    if (error == 0){
      ch = getchar();
      count++;
    }
  }
  
  result = pop();
  
  if (isStackEmpty() == 0){
    few = 1;
    error = -1;
  }
  
  if (error == -1){
    if (fews == 1){
      printf("Input error at character %d (%c); too few arguments on stack.", count, ch);
    }else if(full == 1){
      printf("Stack full when pushing (%f) at position %d", p, count);
    }else if(few == 1){
      printf("There are too few operators in the expression.");
    }
  }else{
    printf("Result: %f", result);
  }
}
