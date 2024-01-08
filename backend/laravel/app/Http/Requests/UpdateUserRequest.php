<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class UpadeUserRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize()
    {
        // return auth()->user()->tokenCan('login');
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<int, string>
     */
    public function rules()
    {
        return [
            'username' => 'sometimes',
            'email' => 'sometimes',
            'password' => 'sometimes',
            'is_active' => 'sometimes',
            'photo' => 'sometimes',
        ];
    }
}