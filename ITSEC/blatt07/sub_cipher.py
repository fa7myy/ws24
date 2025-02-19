alphabet = "abcdefghiklmnopqrstuvwxyz"

def create_table():
    return [list(alphabet[i*5:(i+1)*5]) for i in range(5)]

def create_lookup(table):
    return {table[i][j]: (i + 1, j + 1) for i in range(5) for j in range(5)}

def encrypt(plaintext, lookup):
    ciphertext = ''.join(f"{lookup[letter][0]}{lookup[letter][1]}" for letter in plaintext)
    return ciphertext

def decrypt(ciphertext, lookup):
    plaintext = ''.join(indices[int(ciphertext[i])-1][int(ciphertext[i+1])-1] for i in range(0, len(ciphertext), 2))
    return plaintext

indices = create_table()
lookup = create_lookup(indices)

print(encrypt("uebung", lookup))
print(decrypt("31341543453322", lookup))

plaintext = ' '.join(decrypt(word, lookup) for word in "152433 4313235215425545 14151334142415421533141542 22152315243244155344".split())
print(plaintext)
    
import sympy
phi = 289612468
e   = 17
d   = sympy.invert(e, phi)
print(d)

def decrypt_RSA(cipher_blocks, d, n):
    # The custom base-36 alphabet: A..Z then 0..9
    alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    plaintext = ""

    for c in cipher_blocks:
        # RSA decryption: m = c^d mod n
        m = pow(c, d, n)

        # Convert m to exactly 3 base-36 'digits'
        block_chars = []
        for _ in range(3):
            r = m % 36
            block_chars.append(alpha[r])
            m //= 36

        # The remainder of each division gives us the "least significant" base-36 digit
        # Reverse them to get the correct order
        block_chars.reverse()

        # Append these 3 characters to the final plaintext
        plaintext += "".join(block_chars)

    return plaintext


# Given data:
cblocks = [68094034, 128468343, 143911297, 122013244]
d = 255540413
n = 289648273

# Decrypt
pt = decrypt_RSA(cblocks, d, n)
print("Decrypted plaintext:", pt)
