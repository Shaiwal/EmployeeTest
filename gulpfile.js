// Include gulp
var gulp = require('gulp'); 

// Include Our Plugins
var jshint = require('gulp-jshint');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var file = require('gulp-filesize');
var util = require('gulp-util');
var minifyCSS = require('gulp-minify-css');
// Lint Task
gulp.task('lint', function() {
    return gulp.src('WebContent/js/empUtil.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

// Compile Our Sass

gulp.task('css', function() {
    return gulp.src('WebContent/css/*.css')
        .pipe(concat('style.css'))
        .pipe(minifyCSS())
        .pipe(gulp.dest('WebContent/css'));
});


// Concatenate & Minify JS
/*gulp.task('scripts', function() {
    return gulp.src('WebContent/js/*.js')
        .pipe(concat('all.js'))
        .pipe(gulp.dest('dist'))
        .pipe(uglify())
        .pipe(gulp.dest('dist'));
});*/

// Watch Files For Changes
/*gulp.task('watch', function() {
    gulp.watch('WebContent/js/*.js', ['lint', 'css']);
  //  gulp.watch('scss/*.scss', ['sass']);
});*/

// Default Task
gulp.task('default', ['lint', 'css']);