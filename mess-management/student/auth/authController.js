//const User = require('../schema'); 
const jwt = require('jsonwebtoken');
const Student = require('../schema');
const ManagerOrder=require("../managerOrders");
const {LocalStorage}=require("node-localstorage");
var localstorage=new LocalStorage("./scratch");
const alert=require("alert");

const Messmenu =require('../mess')



const handleErrors = (err) => {
    console.log(err.message, err.code);
    let errors = {
        roll_no: '',
        password: ''
    };

    if (err.message === 'incorrect roll_no') {
        errors.roll_no = 'roll_no is not registered'
    }
    if (err.message === 'incorrect password') {
        errors.roll_no = 'incorrect password'
    }

    // duplicate error code
    if (err.code === 11000) {
        errors['roll_no'] = 'roll_no already registered';
        return errors
    }

    //validation errors 
    if (err.message.includes('User validation failed')) {
        Object.values(err.errors).forEach(({ properties }) => {
            // console.log(properties) //destructuring properties
            errors[properties.path] = properties.message    // error['roll_no] = 'some value'
        })
    }



    return errors;

}


exports.getLogin = (req, res, next) => {
    const { roll_no, password } = req.body;
    console.log('login')

    res.render('si/loginn')
}

exports.postLogin = async (req, res, next) => {
    const { rollno, login_pass } = req.body;
    const rollNum = rollno;
    const password = login_pass;
    try {
        const user = await Student.findOne({rollNum:rollNum,password: password});
        if(!user){
            alert("Incorrect username or password");
            res.redirect("/login");
        }else{
            console.log(user);
        localstorage.setItem("user",rollNum);
        res.redirect("/studentHome");
        }
        
        
    } catch (err) {
        console.log(err);
    }


}

exports.getManagerLogin=async(req,res,next)=>{
    try{
        const email=req.body.email;
        const password=req.body.login_pass_manager;
        if(email=="manager@iiitg.ac.in" && password=="12345678"){
            res.redirect("/managerhome");
        }else{
            res.redirect("/login");
        }
    }catch(err){
        console.log(err)
    }
}

exports.getHome=async(req,res,next)=>{
    try{
        const rollNum=localstorage.getItem("user");
        const student=await Student.find({rollNum:rollNum});
        console.log("ji");
        console.log(student);
        res.render("studentHome",{student});
    }catch(err){
        console.log(err);
    }
}

exports.getManagerHome=async(req,res,next)=>{
    res.render("managementHome");
}

exports.getLogout = (req, res, next) => {
    localstorage.removeItem("user");
    res.redirect('/login')
}

exports.getKnowOrders=async(req,res,next)=>{
    const orders=await ManagerOrder.find({});
    res.render("knoworders",{orders});
}

exports.getManagerDues=async(req,res,next)=>{
    const students=await Student.find({});
    res.render("dues",{students});
}

exports.getMessMenu=async(req,res,next)=>{
    const messmenu=await Messmenu.find({});
    console.log(messmenu)
    res.render("mess-menu",{messmenu});
}