import { Injectable } from '@angular/core';
import {CLIENTES} from "./clientes.json";
import {Cliente} from "./clientes";
import {Observable, of} from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class ClienteService {
  private urlEndPoint: string = 'http://localhost:8080/api/clientes';
  constructor(private http: HttpClient) { }
  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.urlEndPoint);
  }
}
