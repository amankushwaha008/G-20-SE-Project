const express = require('express');
const cookieParser = require('cookie-parser');
const app = express();
const path = require('path');
const mongoose = require('mongoose');
const methodOverride = require('method-override')
const authroutes = require('./student/auth/authRoutes.js')
//const Student = require('./student/schema');
const bookRoutes = require('./student/book');

mongoose.connect('mongodb+srv://mmsDatabaseAdmin:mmsDatabaseAdmin%40123@mmsdatabase.wkimz.mongodb.net/mmsDatabase?retryWrites=true&w=majority', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => {
        console.log("MONGO CONNECTION OPEN!!!")
    })
    .catch(err => {
        console.log("OH NO MONGO CONNECTION ERROR!!!!")
        console.log(err)
    })


app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(express.urlencoded({ extended: true }));
app.use(methodOverride('_method'))
app.use(cookieParser())

app.use(authroutes);
app.use('/book',bookRoutes)


app.listen(9000 , () => {
    console.log("listening on port");
})