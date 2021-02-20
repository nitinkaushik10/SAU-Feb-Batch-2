class student{
    constructor(fname,lname,gender,age,roll,occupation)
    {
        this.fname=fname;
        this.lname=lname;
        this.gender=gender;
        this.age=age;
        this.roll=roll;
        this.occupation=occupation;
     
    }
}
function check(x)
{
    for(let i=0;i<x.length;i++)
    {
        if(!isNaN(x.charAt(i)))
        {
            document.getElementById("send").innerHTML="Enter valid ";
         
            return false;
        }
    }
    return true;
}
function alerter()
{
    document.getElementById("send").innerHTML="fill the required field";
    alert("fill the required field")
}

var print=[];
document.getElementById("btn").onclick = function () {
   
    let x = document.forms["getvalue"]["fname"].value;
    if (x == "") {
        return  alert("required!");
    }
    if(!check(x))
    {
        document.getElementById("send").innerHTML=document.getElementById("send").innerHTML+" First Name";
        return ;
    }
    let fname=x;
    x = document.forms["getvalue"]["lname"].value;
    if (x == "") {
        alerter();
        return;
    }
    if(!check(x))
    {
        document.getElementById("send").innerHTML=document.getElementById("send").innerHTML+" Last Name";
        return;
    }
    let lname=x;
    const choice = document.querySelectorAll('input[name="gender"]');
    let selectedValue;
    for (const i of choice) {
        if (i.checked) {
            selectedValue = i.value;
            break;
        }
    }
    if(selectedValue==undefined)
    {
        alerter();
        return;
    }
    let gender=selectedValue;
    x=document.forms["getvalue"]["age"].value;
    if( x=="")
    {
        alerter();
        return;
    }
    for(let i=0;i<x.length;i++)
    {
        if(isNaN(x.charAt(i)))
        {
            document.getElementById("send").innerHTML="Enter the valid Age";
            alert("Please Enter the valid Age")
            return;
        }
    }
    let age=x;
    x = document.forms["getvalue"]["roll"].value;
    if (x == "") {
        alerter();
        return;
    }
    let roll=x;
    x = document.forms["getvalue"]["occupation"].value;
    if (x == "") {
        alerter();
        return;
    }
    let occupation=x;
    
    document.getElementById("send").innerHTML="";
    print.push(new student(fname,lname,gender,age,roll,occupation));
}



document.getElementById("btn1").onclick = function () {
    let x = document.forms["get"]["roll"].value;
    for(let i=0;i<print.length;i++)
    {
        if(print[i].roll==x)
        {
            document.getElementById("search").innerHTML="<br>First Name: "+ print[i].fname+"<br>Last Name: "+print[i].lname+"<br>Gender: "+print[i].gender+"<br>Age: "+print[i].age+"<br>Roll No: "+print[i].roll+"<br>Occupation: "+print[i].occupation;
        }
    }
}