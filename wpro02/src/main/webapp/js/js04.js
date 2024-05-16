/**
 js 별도 작성. 모드를 설치하면 독립적으로 수행 가능하긴 하지만 보통은 독립적으로 수행되지 않음. 
 */

 let i = 0, tot = 0;
 do {
	i++;
	tot += i;
 }while (i < 10);
 
 document.write(`<br>합은 ${tot}`);