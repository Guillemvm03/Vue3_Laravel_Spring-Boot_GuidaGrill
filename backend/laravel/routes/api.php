<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TableController;

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

// Route::get('/mesas', [MesasController::class,'index']);
// Route::get('/mesas/{id}', [MesasController::class,'show']);

Route::resource('tables', TableController::class);



// Route::post('/pistas', [PistaController::class,'store']);
// Route::get('/pistas/{id}', [PistaController::class,'show']);
// Route::put('/pistas/{id}', [PistaController::class,'update']);
// Route::delete('/pistas/{id}', [PistaController::class,'destroy']);