import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map, tap} from 'rxjs/operators';

@Component({
    selector: 'home',
    templateUrl: './home.component.html'
})

export class HomeComponent implements OnInit {

    userName: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private http: HttpClient
    ) { }

    ngOnInit() {

        // Verifica se ja esta logado
        if (sessionStorage.getItem('token').length == 0){
            this.router.navigate(['login']);
        } else {
        
            // Monta a url de acesso
            let url = 'http://localhost:8081/user';

            // Prepara o header com o token de acesso
            let headers: HttpHeaders = new HttpHeaders({
                'Authorization': 'Basic ' + sessionStorage.getItem('token')
            });

            // Efetua a requisicao
            let options = { headers: headers };
            this.http.post<Observable<Object>>(url, {}, options).
                subscribe(principal => {
                    this.userName = principal['name'];
                },
                error => {
                    if(error.status == 401)
                        alert('Nao rolou!!!');
                }
            );

        }
    }

    logout() {
        sessionStorage.setItem('token', '');
    }

    private handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
          console.error('Erro:', error.error.message);
        } else {
          console.error(
            'Retorno backend status: ${error.status}, ' +
            'erro: ${error.error}');
        }
        return throwError(
          'Erro Generico.');
      };
}
