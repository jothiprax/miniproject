public static int getJobLevel(double salary){
    if(salary<10000){
        return 1;

    }
    else if(salary>10000 && salary<30000){
        return 2;
    }
    else if(salary>30000 && salary<50000 ){
        return 3;
    }
    else{
        return 0;
    }
}