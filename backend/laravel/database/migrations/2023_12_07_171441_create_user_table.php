<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{

    public function up()
    {
        Schema::create('users', function (Blueprint $table) {
            $table->id();
            $table->string('username')->unique();
            $table->string('password');
            $table->string('email')->unique();
            $table->string('type');
            $table->boolean('is_active');
            $table->string('photo');
            $table->timestamps();

        });
    }


    public function down()
    {
        Schema::dropIfExists('users');
    }
};
