const express = require('express').Router;
const Student = require('./schema');
const ManagerOrder=require("./managerOrders");
const {LocalStorage}=require("node-localstorage");
var localstorage=new LocalStorage("./scratch");

const router = express()

router.get('/', async (req, res) => {
    res.render('bookmeal');
});

router.post('/', async (req, res) => {
    const date = req.body.daterange
    const start = Date.parse(date.split('-')[0])
    const end = Date.parse(date.split('-')[1].trim())
    const { bf, lunch, dinner } = req.body;
    console.log(req.body)
    const diff=Math.abs((end - start) / (1000 * 60 * 60 * 24))+1;
    const rollNum=localstorage.getItem("user");
    const student=await Student.findOne({rollNum:rollNum});
    var sum=0;
    if(bf==0){
        sum+=diff*40;
    }
    if(lunch==0){
        sum+=diff*45;
    }
    if(dinner==0){
        sum+=diff*60;
    }
    var totaldues=parseInt(student.dues);
    
    totaldues-=sum;
    console.log(sum);
    console.log("totaldues"+totaldues);
    student.dues=totaldues;
    const managerorder=new ManagerOrder();
    managerorder.name=student.name;
    managerorder.rollnum=student.rollNum;
    managerorder.duration=diff;
    managerorder.dates=date;
    managerorder.bf=bf;
    managerorder.lunch=lunch;
    managerorder.dinner=dinner;
    await managerorder.save();
    console.log("totaldues after saving"+student.dues);
    await student.save();
    res.redirect('/studentHome');
})

module.exports = router;