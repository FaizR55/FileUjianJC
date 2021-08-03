class draw{
    gambarKotak(r){

        for(let i = 0 ; i<r ; i++){
            
            for(let j = 0 ; j<r ; j++){
                process.stdout.write("* ")
            }console.log(" ")
        }
        console.log("\n")
    }

    gambarSegitiga(r){

        for(let i = 0 ; i<r ; i++){

            for(let j = 0 ; j<=i ; j++){
                process.stdout.write("* ")
            }console.log(" ")
        }
        console.log("\n")
    }

    gambarSegitigaTerbalik(r){

        for(let i = 0 ; i<r ; i++){
            
            for(let j = r ; j>i ; j--){
                process.stdout.write("* ")
            }console.log(" ")
        }
        console.log("\n")
    }

    gambarSelangSeling(r){

        for(let i = 0 ; i<r ; i++){

            for(let j = 0 ; j<r ; j++){

                if((i%2==0 && j%2==1) || (i%2==1 && j%2==0) ){
                    process.stdout.write("!")
                }else{
                    process.stdout.write("*")
                }
                
            }console.log(" ")
        }
        console.log("\n")
    }

    gambarKotakPola(r){

        for(let i = 0 ; i<r ; i++){

            for(let j = 0 ; j<r ; j++){

                if(i%2==0){
                    if(j==2){
                        process.stdout.write("!")
                    }
                    else{
                        process.stdout.write("*")
                    }
                }else if(i%2==1){
                    if(j==1){
                        process.stdout.write("!")
                    }
                    else{
                        process.stdout.write("*")
                    }
                }
                
            }console.log(" ")
        }
        console.log("\n")
    }
}

var kotak = new draw();
kotak.gambarKotak(10);

var segitiga = new draw();
segitiga.gambarSegitiga(10)

var segitigaTerbalik = new draw();
segitigaTerbalik.gambarSegitigaTerbalik(10);

var selangseling = new draw();
selangseling.gambarSelangSeling(10);

var kotakpola = new draw();
kotakpola.gambarKotakPola(10);