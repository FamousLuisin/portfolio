import { Component } from '@angular/core';
import { HeaderComponent } from "./components/header/header.component";
import { ProfileComponent } from "./components/profile/profile.component";

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, ProfileComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'client';
}
