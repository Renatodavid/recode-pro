var myCarousel = document.getElementById('carouselExample');
var myCarousel1 = new bootstrap.Carousel1(myCarousel1);

var count = 0;
var inc = 0;
var margin = 0;
var slider = document.getElementsByClassName("slider-width")[0];
var itemDisplay = 0;
if(screen.width > 990){
    itemDisplay = Document.getElementsByClassName("slider-container")[0] .getAttribute("item-display-d");
    margin = itemDisplay * 5;
}   
if(screen.width > 700 && screen.width< 990 ){
    itemDisplay = Document.getElementsByClassName("slider-container")[0] .getAttribute("item-display-t");
    margin = itemDisplay * 6.8;
}  
if(screen.width > 280 && screen.width< 700 ){
    itemDisplay = Document.getElementsByClassName("slider-container")[0] .getAttribute("item-display-m");
    margin = itemDisplay * 20;
} 

var item = document.getElementsByClassName("item");
var itemleft = item.length % itemDisplay;
var itemSlide = math.Floor(item.length / itemDisplay) - 1;
for(let i=0; i<item.length; i++){
    item[i].style.width = (screen.width / itemDisplay)- margin + "px";
}

function next(){
    if(inc !== 0){
        if (inc === itemSlide) {
            inc = inc + itemleft
            count = count - (screen.width / itemDisplay)* itemleft;
        }
        else{
            inc ++;
            count = count - screen.width;
        }
    }
    function prev(){
        if(inc !== 0){
            if (inc === itemleft) {
                inc = inc - itemleft
                count = count + (screen.width / itemDisplay) * itemleft;
            }
            else{
                inc ++;
                count = count + screen.width;
            }
        }
    }
    
}

