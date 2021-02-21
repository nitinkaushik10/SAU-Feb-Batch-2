import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class EmployeedbService {

  employeeList = [
    {Firstname : "Nitin", Lastname : "Kaushik", address:"Delhi", dob : "1999-05-10" , contact: "9999912349" , pincode: "201312"},
    {Firstname : "Ayush", Lastname : "Sharma", address:"Gurgaon", dob : "1998-04-20" , contact: "9999912348" , pincode: "201316"}
   
  ];

  constructor() { }

  getEmployees(){
    return this.employeeList;
  }

  getEmployeeByIndex(index){
    return this.employeeList[index];
  }

  addEmployee(employee){
    this.employeeList.push(employee);
   
  }

  deleteEmployeeByIndex(index){
    this.employeeList.splice(index, 1);
  }

  updateEmployeeByIndex(index, employee){
    this.employeeList[index] = employee;
   
  }

}
