import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';
import { state } from '@angular/animations';

@Injectable({
  providedIn: 'root'
})
export class FiboService {

  constructor(private httpClient: HttpClient, private rounter: Router) { }
  api: String = "http://localhost:8080/";

  getFiboNo(input: any) {
    // console.log(this.api+"fiboNo/"+input);
    this.httpClient.get(this.api+"fiboNo/"+input).subscribe(
      (response) => {
        this.rounter.navigate(['/output'], {state: {response, input}});
      },
      (error) =>{
        alert("Something went wrong");
        throw new Error('Error occured');
      }
    );
    
  }

}
