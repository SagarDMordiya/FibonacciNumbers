import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.css']
})
export class OutputComponent {

  constructor(private router: Router) { }
  result = history.state.response;
  input = history.state.input;

  redirectHome() {
    this.router.navigateByUrl('/input');
  }

}
