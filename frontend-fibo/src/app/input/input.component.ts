import { Component } from '@angular/core';
import { FiboService } from '../fibo.service';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})

export class InputComponent {

  constructor(private fiboService: FiboService) { }

  input!: number;
  ngOnInit() {
    console.log("inside this");
  }
  onSubmit() {
    if (Number.isInteger(this.input)) {
      console.log(this.input)
      this.fiboService.getFiboNo(this.input);
    }
    else {
      alert("Please enter a Valid Integer");
    }
  }

}
