<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class StoreTableRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, mixed>
     */
    public function rules()
    {
        return [
            'id_menu' => 'required',
            'name' => 'required',
            'price' => 'string',
            'quantity' => 'required',
            'description' => 'required',
            'img_meal' => 'required',
            'meals' => 'required', 'array:name, meals'
        ];
    }
}
