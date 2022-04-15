const mongoose = require('mongoose');
//const { isroll_no } = require('validator')
const bcrypt = require('bcrypt')

//const Schema = mongoose.Schema;

const managerOrderSchema = new mongoose.Schema({
    rollnum:String,
    name:String,
    dates:String,
    duration:String,
    bf:String,
    lunch:String,
    dinner:String
})






const ManagerOrder = mongoose.model('ManagerOrder', managerOrderSchema);

module.exports = ManagerOrder;