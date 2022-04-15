const mongoose = require('mongoose');

const rollSchema = new mongoose.Schema({
    roll:{
        type:Number,
        required:true
    }
})

module.exports = mongoose.model('Roll',rollSchema)
