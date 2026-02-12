import { CapacitorCalendar } from 'capacitor-calendar-plugin';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    CapacitorCalendar.echo({ value: inputValue })
}
