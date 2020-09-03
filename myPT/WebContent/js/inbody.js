
function numRound(x,num) 
{
  return Number.parseFloat(x).toFixed(num);
  
}

//	날짜 포맷 yy.MM.dd	
	function getDateFormat(text)
	{
		 let a  = new Date(text);
		 
		 let year= (String)(a.getFullYear()).substring(2,4);
		 let month = a.getMonth()+1;
		 let day=  a.getDate();
		 
		 if(month<10)
		 {
		   month = "0"+month;
		 }
		 if(day<10)
		 {
		  day = "0"+day;
		 }
		 
		 return year+"."+month+"."+day;
		 
	}
	
//////



	var ageDiv= document.querySelector("#age");

	var myAge = ageDiv.innerHTML;
	
	var birthdate= new Date(myAge);
	var today= new Date();

	// 나이구하기
	var years = today.getFullYear()- birthdate.getFullYear();

	// 생일비교를 위해 생년도를 올해로 세팅
	birthdate.setFullYear(today.getFullYear);
	if(today<birthdate)
	{
	    years= years-1;
	}

	ageDiv.innerHTML= "만 "+ years + "세";

	
	
//////
	
	var before= document.querySelectorAll(".before");
	var after= document.querySelectorAll(".after");
	var result= document.querySelectorAll(".result");

	
	
	for(let i=0; i<before.length; i++)
	{   
		
	    var subResult= after[i].textContent-before[i].textContent;
	    subResult= numRound(subResult,1);
	    
	    if(i==1)
	    {
	        if(subResult<0)
	        {
	            getResult(i,"red", subResult);
	        }
	        else
	        {
	            getResult(i,"blue", "+"+subResult);
	        }
	    }
	    else
	    {
	        if(subResult<0)
	        {
	            getResult(i,"blue", subResult);
	        }
	        else
	        {
	            getResult(i,"red", "+"+subResult);
	        }
	    }
	}

	function getResult(num, color, res)
	{
	    result[num].style.color= color;
	    result[num].innerHTML= res;
	}

	
//////
	
		

	var latestMeasureDayDiv = document.querySelector("#latestMeasureDay");
	var showLDay = document.querySelector(".latestMeasureDay");
	
	var beforeWeight=  document.querySelector(".weight");
	var beforeMuscle=  document.querySelector(".muscle");
	var beforeFat=  document.querySelector(".fat");

//	showLDay.innerText= latestMeasureDay.innerText
	showLDay.innerText= getDateFormat(latestMeasureDayDiv.innerText)


	var previousMeasureDay = document.querySelector("#previousMeasureDay");
	var showPDay= document.querySelector(".previousMeasureDay");

	function preDayIschanged()
	{
	    showPDay.innerText= getDateFormat(previousMeasureDay.options[previousMeasureDay.selectedIndex].innerText)
	    
//	    [previousMeasureDay.selectedIndex]
	    beforeWeight.innerText=	'${arr[previousMeasureDay.selectedIndex].inbody.weight}';
	    beforeMuscle.innerText=	'${arr[previousMeasureDay.selectedIndex].inbody.muscle}';
	    beforeFat.innerText=	'${arr[previousMeasureDay.selectedIndex].inbody.fat}';


	    
	    
	}

	function numOfResultIschanged()
	{
	   
	}


///////
	

    var beforAfterNums= document.querySelectorAll(".nums");
    
    for (let i = 0, length= beforAfterNums.length; i < length; i++) 
    {
        numRound(beforAfterNums[i], 2)
    }