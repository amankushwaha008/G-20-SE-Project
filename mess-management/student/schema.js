const mongoose = require('mongoose');
//const { isroll_no } = require('validator')
const bcrypt = require('bcrypt')

//const Schema = mongoose.Schema;

const studentSchema = new mongoose.Schema({
    rollNum:String,
    name:String,
    userName:String,
    password:String,
    email:String,
    batch:String,
    dept:String,
    breakfast:Boolean,
    lunch:Boolean,
    dinner:Boolean,
    dues:String,
    year:String
})






const Student = mongoose.model('Student', studentSchema);

module.exports = Student;