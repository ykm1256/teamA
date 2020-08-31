var before= document.querySelectorAll(".before");
var after= document.querySelectorAll(".after");
var result= document.querySelectorAll(".result");

for(let i=0; i<before.length; i++)
{   
    var subResult= after[i].textContent-before[i].textContent;
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

/////
var latestMeasureDay = document.querySelector("#latestMeasureDay");
var showLDay = document.querySelector(".latestMeasureDay");

showLDay.innerText= latestMeasureDay.innerText

var previousMeasureDay = document.querySelector("#previousMeasureDay");
var showPDay= document.querySelector(".previousMeasureDay");

function preDayIschanged()
{
    showPDay.innerText= previousMeasureDay.options[previousMeasureDay.selectedIndex].innerText;
}

function numOfResultIschanged()
{
   
}


/////