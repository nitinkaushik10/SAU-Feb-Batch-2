class input {
    constructor(param) {
        this.input = param;
    }

    IsNumberPresent() 
    {
        if(/[0-9]/.test(this.input))
        {
             alert("Number is present in the string");
        }
        return /[0-9]/.test(this.input);
    }

    IsUpperCase() {
        return this.input.toUpperCase();
    };
    IsLowerCase() {
        return this.input.toLowerCase();
    };
    LengthOfString() {
        return this.input.length;
    };
   
    separate_Vowel_Consonant() 
    {
                let str = this.input;
                let cons="";
             let vows="";
        
                for(let i = 0; i < str.length ; i++)
                    {
                        if (/[aeiouAEIOU]/.test(str[i]))
                            {
                            vows=vows+str[i];
                            }
                        else{
                            cons=cons+str[i];
                        }
                        
                    }
                    
                    return "Vowels are:  " + vows+ " and Consonents are : " + cons;
        }
        
    IsNumberProsent() 
    {
        if(/[0-9]/.test(this.input))
        {
             alert("Number is present in the string! - Write string without Numbers ");
        }
        return /[0-9]/.test(this.input);
    }
}

function answer() {
    let inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    document.getElementById("len").innerHTML = inputObject.LengthOfString();
    document.getElementById("upper").innerHTML = inputObject.IsUpperCase();
    document.getElementById("lower").innerHTML = inputObject. IsLowerCase();
    document.getElementById("v").innerHTML = inputObject. separate_Vowel_Consonant();
    document.getElementById("c").innerHTML = inputObject.IsNumberPresent();
    
}