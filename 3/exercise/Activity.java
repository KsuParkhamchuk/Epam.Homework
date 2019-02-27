/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;
import java.util.Scanner;


public class Activity {
    
    public static void CreateMatrix(){
      int lines=0;
      int columns=0;  
      int min=0;
      int max=0;
      System.out.println("Enter humber of lines:");
      lines=Check();
      System.out.println("Enter humber of columns:");
      columns=Check();
      System.out.println("Matrix is generated from ");
      min=Check();
      System.out.println("to ");
      max=Check();
      double [][]matrix=new double[lines][columns];
      Random r=new Random();
      for(int i=0;i<lines;i++){
          System.out.println('\n');
          for(int j=0;j<columns;j++){
              matrix[i][j]=r.nextInt(max-min)+min+r.nextDouble();
              System.out.print(matrix[i][j]+" ");
          }
      }
      Menu(matrix,lines,columns);
      
    }
    
   public static void Menu(double matrix[][],int size1,int size2){
        int choice;
        boolean isInputCorrect=false;
        
      do{
        Scanner sc=new Scanner(System.in);
        System.out.println("\nMenu:\n1-Find max and min element\n2-Find Arithmitical and geometrical mean\n3-Local minimums and maximums\n4-Transpose matrix\n0-Finish work");
        choice=sc.nextInt();
        switch(choice){
            case 1: 
                    FindMaxAndMinElement(matrix,size1,size2);
                break;
            case 2:
                   CountArithmeticalAndGeometricalMean(matrix,size1,size2);
                break;
            case 3: 
                    FindLocalMinimumAndMaxsimum(matrix,size1,size2);
                break;
            case 4:TransposeMatrix();
                break;
            case 0: 
                    isInputCorrect=true;
                break;
            default: System.out.println("Make another choice");
                break;
        } 
        }while(!isInputCorrect);
      }
    
    public static void FindMaxAndMinElement(double matr[][],int size1,int size2){
        double maxElement=matr[0][0];
        double minElement=matr[0][0];
        for(int i=0;i<size1;i++){
            for(int j=0;j<size2;j++){
                
                if(matr[i][j]>maxElement){
                    maxElement=matr[i][j];
                }else{ 
                    if(matr[i][j]<minElement){
                          minElement=matr[i][j];       
                }
                }
            }
        }
        System.out.println("Max element= "+maxElement);
        System.out.println("Min element= "+minElement);
        
    }
    
    
    public static void CountArithmeticalAndGeometricalMean(double matr[][],int size1,int size2){
        double arMean;
        double gMean;
        double sum=0;
        double mult=1;
        for(int i=0;i<size1;i++){
            for(int j=0;j<size2;j++){
                sum+=matr[i][j];
                mult*=matr[i][j];
            }
        }
        System.out.println(sum+" "+mult);
        arMean=new BigDecimal(sum/(size1*size2)).setScale(3,RoundingMode.HALF_UP).doubleValue();
        gMean=new BigDecimal(Math.pow(mult,(double)1/(size1*size2))).setScale(3,RoundingMode.HALF_UP).doubleValue();
        System.out.println("Arithmetical Mean:"+ arMean);
        System.out.println("Geometrical Mean:"+ gMean);
    }
    
    public static boolean IsNeighbourExist(double matr[][],int x,int y){
        return !(x<0 || y<0 || x==matr.length || y==matr[0].length);
    }
    
    public static boolean IsLocalMaximum(double matr[][],int x,int y){
        boolean isLocalMaximum=true;
        if(IsNeighbourExist(matr,x-1,y))
        {
            if(matr[x][y]<matr[x-1][y])
                isLocalMaximum=false;
        }
        if(IsNeighbourExist(matr,x+1,y))
        {
            if(matr[x][y]<matr[x+1][y])
                isLocalMaximum=false;
            
        }
        if(IsNeighbourExist(matr,x,y-1))
        {
               if(matr[x][y]<matr[x][y-1])
                isLocalMaximum=false;

        }
        if(IsNeighbourExist(matr,x,y+1))
        {
            if(matr[x][y]<matr[x][y+1])
                isLocalMaximum=false;

        }
      return isLocalMaximum;  
    }
    
     public static boolean IsLocalMinimum(double matr[][],int x,int y){
        boolean isLocalMinimum=true;
        if(IsNeighbourExist(matr,x-1,y))
        {
            if(matr[x][y]>matr[x-1][y])
                isLocalMinimum=false;
        }
        if(IsNeighbourExist(matr,x+1,y))
        {
            if(matr[x][y]>matr[x+1][y])
                isLocalMinimum=false;
            
        }
        if(IsNeighbourExist(matr,x,y-1))
        {
               if(matr[x][y]>matr[x][y-1])
                isLocalMinimum=false;

        }
        if(IsNeighbourExist(matr,x,y+1))
        {
            if(matr[x][y]>matr[x][y+1])
                isLocalMinimum=false;

        }
      return isLocalMinimum;  
    }
    
    public static void FindLocalMinimumAndMaxsimum(double matr[][],int size1,int size2){
        for(int i=0;i<size1-1;i++){
            for(int j=0;j<size2-1;j++){
                if(IsLocalMaximum(matr,i,j))
                   System.out.println("Element matr ["+i+"]["+j+"]="+matr[i][j]+ " is local maximum");  
                if(IsLocalMinimum(matr,i,j)){
                    System.out.println("Element matr ["+i+"]["+j+"]="+matr[i][j]+ " is local minimum");
                }                
            }
        }
    }
    
    public static void TransposeMatrix(){
        int size1;
        int size2;
        double temp=0;
        Random rand= new Random();
        System.out.println("enter number of rows: ");
        size1=Check();
        System.out.println("Enter number of columns:");
        size2=Check();
        System.out.println("Enter the borders,from ");
       int min=Check();
       System.out.println("To ");
       int max=Check();
        double rows=size1;
        double columns=size2;
        int count=0;
        
        if(size1<size2){   
            count=size2-size1;
            size1=size2;
        }else{
           count=size1-size2;
           size2=size1;         
        }
       
       double [][]matrix=new double[size1][size2];
       System.out.print(rows);
       for(int i=0;i<rows;i++){
          System.out.println();
          for(int j=0;j<columns;j++){
              matrix[i][j]=rand.nextInt(max-min)+min+rand.nextDouble();
              System.out.print(matrix[i][j]+" ");
          }
      }
       for(int i=0;i<size1;i++){
           for(int j=0;j<size2;j++){
               temp=matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=temp;
           }
       }
       
       for(int i=0;i<rows;i++){
          System.out.println();
          for(int j=0;j<columns;j++){
              System.out.print(matrix[j][i]+"  ");
          }
      }       
        }
    

    
    public static int Check(){
        int value =0xFFFFFF;
        do{
            try{
            Scanner sc=new Scanner(System.in);
            value=sc.nextInt();
            }catch(Exception ex){
                System.out.println("Error:"+ex.getMessage());
            }
        }while(value==0xFFFFFF);
        return value;
    }
 
    
}
