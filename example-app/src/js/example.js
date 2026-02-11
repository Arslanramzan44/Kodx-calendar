import { KodxCalendar } from 'y';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    KodxCalendar.echo({ value: inputValue })
}
