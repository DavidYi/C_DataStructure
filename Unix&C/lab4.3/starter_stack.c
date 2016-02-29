#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "stack.h"

typedef struct node{
  int val;
  struct node* next;
} Node;

struct stack{
  int stackSize;
  Node* head;
};

Stack* createStack (){
  Stack *s = malloc(sizeof(Stack));
  s->stackSize = 0;
  s->head = NULL;

  return s;
}

void push (Stack *s, int val){
  Node *n;
  int i;

  n = malloc(sizeof(Node));
  n->val = val;
  n->next = NULL;

  if (s->stackSize > 0){
    n->next = s->head;
  }
  s->head = n;
  s->stackSize++;
}

int pop (Stack *s){
  int val;
  Node *n;
  if (s->stackSize == 0)
    return INT_MIN;

  val = s->head->val;
  n = s->head;
  
  s->head = s->head->next;
  s->stackSize--;
  free(n);
  return val;
}

int isStackEmpty (Stack *s)
{
  if (s->stackSize == 0)
    return 1;
  else
    return 0;
}

int getStackSize(Stack *s)
{
  return s->stackSize;
}

