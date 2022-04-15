const mongoose = require('mongoose');

const bookingSchema = new mongoose.Schema({
    id: {
        type: mongoose.Schema.Types.ObjectId,
        required: true,
        ref: 'Student'
    },
    start: {
        type: Number,
        required: true
    },
    end: {
        type: Number,
        required: true
    },
    bf: {
        type: Number, default: 1
    },
    lunch: {
        type: Number, default: 1
    },
    dinner: {
        type: Number, default: 1
    },

})

module.exports = mongoose.model('Booking', bookingSchema)