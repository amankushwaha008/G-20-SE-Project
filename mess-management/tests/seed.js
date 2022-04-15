const Roll = require('./../student/Roll.model');

const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27017/messManagement').then(async(result) => {
    let roll = 2001001;
    while (roll<=2001200) {
        await Roll.create({
            roll
        })
        console.log(roll);
        roll++;
        
    }
}).catch((err) => {
    console.log(err)
    process.exit(0);
});