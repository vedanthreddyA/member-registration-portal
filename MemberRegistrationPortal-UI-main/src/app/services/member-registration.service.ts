import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Member } from '../modal/member';
import { Observable, throwError } from 'rxjs';
import { Dependents } from '../modal/dependents';
import { Customer } from '../modal/customer';
import { retry, catchError } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class MemberRegistrationService {

  getCustomerByMemberIdURL: string;
  getCustomrByIdURL: string;
  updateMemberURL: string;
  constructor(public httpCLient: HttpClient) {
    this.getCustomerByMemberIdURL = "http://localhost:9092/getcustomer";
    this.getCustomrByIdURL = "http://localhost:9092/findcustomer";
    this.updateMemberURL = "http://localhost:9092/updatecustomer";
  }

  saveMember(member: Member): Observable<any> {
    // const requestOptions: Object = {
    //   /* other options here */
    //   responseType: 'text'
    // }
    return this.httpCLient.post<Member>("http://localhost:9092/savecustomer", member).pipe (
      retry (1),
      catchError(this.handleError)
    );
  }
  handleError(err:HttpErrorResponse) {
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      // if error is client-side error
      errorMessage = `Error: ${err.message}`;
    } else {
      console.log('error',err);
      // if error is server-side error
      errorMessage = `Message: ${err.error.message}`;
      if(err.status == 500){
        errorMessage = "Some thing went worng please try again"
      }
    }
    alert(errorMessage);
    return throwError(errorMessage);
  }
  

  saveDependents(dependents: Dependents): Observable<any> {
    // const requestOptions: Object = {
    //   /* other options here */
    //   responseType: 'text'
    // }
    return this.httpCLient.post<Dependents>("http://localhost:9092/savedependent", dependents).pipe (
      retry (1),
      catchError(this.handleError)
    );
  }
  getMemberByMemberId(memberId: string): Observable<Member[]> {
    return this.httpCLient.get<Member[]>(`${this.getCustomerByMemberIdURL}/${memberId}`);
  }
  getMemberById(id: number): Observable<any> {
    return this.httpCLient.get(`${this.getCustomrByIdURL}/${id}`);
  }
  updateMember(member: Member, id: number) {
    return this.httpCLient.put(`${this.updateMemberURL}/${id}`, member);
  }
  getAllMember(): Observable<any> {
    return this.httpCLient.get("http://localhost:9092/getAllcustomers");
  }
}
