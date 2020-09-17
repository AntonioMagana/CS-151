package StackMac;

import java.util.*;

public class Stack<T> {
    private ArrayList<T> aList;

    public Stack(){
        aList = new ArrayList<>();
    }

    public void push(T val) {
        aList.add(val);
    }

    public int size(){
        return aList.size();
    }


    public T pop(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        else {
            T last = aList.get(aList.size()-1);
            aList.remove(last);
            return last;
        }
    }

    public T top(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        else {
            T last = aList.get(aList.size()-1);
            return last;
        }
    }

    public void clear(){
        aList.clear();
    }

    public boolean isEmpty(){
        if(aList.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return aList.toString();
    }
}