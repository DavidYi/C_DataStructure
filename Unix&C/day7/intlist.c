#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "intlist.h"

typedef struct node{
  int val;
  struct note *next;
} Node;

struct intlist{
  Node *head;
  Node *tail;
  int listSize;
};

IntList* ilCreate(){
  IntList* il = malloc(sizeof(IntList));
  il->head = NULL;
  il->tail = NULL;
  il->listSize = 0;

  return il;
}

void ilAppend(IntList *il, int val){
  Node *n;
  
  n = malloc (sizeof(Node));
  n->val = val;
  n->next = NULL;

  if (il->listSize == 0){
    il->head = n;
    il->tail = n;
    il->listSize++;
  }else{
    il->tail->next = n;
    il->tail = n;
    il->listSize++;
  }
}

void ilPrint (IntList* il){
  Node* n;
  int i = 0;

  n = il->head;

  while (n != NULL){
    printf("%d :  %d\n", i, n->val);
    n = n->next;
    i++;
  }
}

int ilFind(IntList *il, int val){
  Node* n;
  int i = 0;
  
  n = il->head;

  while (n != NULL){
    if (n->val == val)
      return i;
    i++;
    n = n->next;
  }
  return -1;
}

int ilSize(IntList *il){
  return il->listSize;
}

int ilInsert(IntList *il, int pos, int val){
  Node* newNode;
  Node* n;
  int i;

  if ((pos < 0) || (pos >= il->listSize))
    return INT_MIN;

  newNode = malloc(sizeof(Node));
  newNode->val = val;

  if (pos == 0){
    newNode->next = il->head;
    il->head = newNode;
  }else{
    n = il->head;
    for (i = 0; i < pos - 1; i++)
      n = n->next;
    newNode->next = n->next;
    n->next = newNode;
  }
  il->listSize++;
}

int ilGet (IntList *il, int pos){
  int i;
  Node *n;

  if ((pos < 0) || (pos >= il->listSize))
    return INT_MIN;

  n = il->head;

  for (i = 0; i < pos; i++)
    n = n->next;
  
  return n->val;
}

int ilDelete (IntList *il, int pos){
  int i;
  Node *n;
  Node *del;
  
  if ((pos < 0) || (pos >= il->listSize))
    return -1;

  if (il->listSize == 1){
    il->head = NULL;
    il->tail= NULL;
    il->listSize = 0;
  }else if (pos == 0){
    il->head = il->head->next;
    il->listSize--; 
  }else{
    n = il->head;
    
    for (i = 0; i < pos - 1; i++)
      n = n->next;
  
    del = n->next;
    n->next = del->next;
    free (del);
    il->listSize--;

    if (il->tail == del)
      il->tail = n;
  }

  return 0;
}
