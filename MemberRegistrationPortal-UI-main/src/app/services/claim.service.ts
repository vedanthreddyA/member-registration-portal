import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Claim } from '../modal/claim';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class ClaimService {

  constructor(private httpClient: HttpClient) { }

  createClaim(claim: Claim): Observable<Object> {
    return this.httpClient.post<Claim>("http://localhost:9092/createClaim", claim).pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  createClaimForDependent(dependentclaim: Claim): Observable<Object> {
    return this.httpClient.post<Claim>("http://localhost:9092/dependentclaim", dependentclaim).pipe(
      retry(1),
      catchError(this.handleError)
    );
  }
  handleError(err: HttpErrorResponse) {
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      // if error is client-side error
      errorMessage = `Error: ${err.message}`;
    } else {
      console.log('error', err);
      // if error is server-side error
      errorMessage = `Message: ${err.error.message}`;
    }
    alert(errorMessage);
    return throwError(errorMessage);
  }
}
