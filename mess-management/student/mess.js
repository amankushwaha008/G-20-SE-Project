const mongoose = require('mongoose');
//const { isroll_no } = require('validator')
const bcrypt = require('bcrypt')

//const Schema = mongoose.Schema;

const MessMenuSchema = new mongoose.Schema({
    day:String,
    b1:String,
    b2:String,
    b3:String,
    l1:String,
    l2:String,
    l3:String,
    d1:String,
    d2:String,
    d3:String,
    
})






const MessMenu = mongoose.model('MessMenu', MessMenuSchema);

module.exports = MessMenu;