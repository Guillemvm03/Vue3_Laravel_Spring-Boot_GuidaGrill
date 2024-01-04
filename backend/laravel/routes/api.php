<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TableController;
use App\Http\Controllers\MenuController;
use App\Http\Controllers\mealsController;
use App\Http\Controllers\ReservationController;
use App\Http\Controllers\UserController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

// Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
//     return $request->user();
// });


Route::group(['middleware' => ['admin']], function () {
    Route::resource('tables', TableController::class);
    Route::resource('menu', MenuController::class);
    Route::resource('meals', mealsController::class);
    Route::resource('users', UserController::class);
    Route::resource('reservations', ReservationController::class);
});

Route::post('/login', [UserController::class,'login']);

Route::post('/logout', [UserController::class,'logout']);

Route::get('profile', [UserController::class,'getUserToken']);

Route::get('isAdmin', [UserController::class,'isAdmin']);

Route::put('/api/users/{id}', 'UserController@update');
